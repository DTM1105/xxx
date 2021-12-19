package com.nhom8.hethongguitien.controller;


import com.nhom8.hethongguitien.common.ERole;
import com.nhom8.hethongguitien.common.JwtUtils;
import com.nhom8.hethongguitien.dto.JwtResponse;
import com.nhom8.hethongguitien.dto.LoginRequest;
import com.nhom8.hethongguitien.dto.MessageResponse;
import com.nhom8.hethongguitien.dto.SignupRequest;
import com.nhom8.hethongguitien.model.*;
import com.nhom8.hethongguitien.repository.RoleRepository;
import com.nhom8.hethongguitien.repository.TkkhRepository;
import com.nhom8.hethongguitien.repository.TkthanhtoanRepository;
import com.nhom8.hethongguitien.repository.TktietkiemRepository;
import com.nhom8.hethongguitien.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TkkhRepository tkkhRepository;
    @Autowired
    TktietkiemService tktietkiemService;
    TktietkiemRepository tktietkiemRepository;
    @Autowired
    TkthanhtoanService tkthanhtoanService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private TkkhRepository repository;
    private UserService userService;
    @GetMapping("/user")
    public List<Tkkh> getAllUsers() {
        return repository.findAll();
    }
    @PostMapping("/user/add")
    public String add(@RequestBody Tkkh user){
        userService.saveUser(user);
        return "New user is added";
    }
    //Get detail product
    @GetMapping("/user/{id}")
    //Let's return an object with: data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable Integer id) {
        Optional<Tkkh> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query product successfully", foundProduct)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find product with id = "+id, "")
                );
    }
    @GetMapping("/tktk")
    public List<Tktietkiem> getAllTktietkiems() {
        return tktietkiemService.getAllTktietkiems();
    }
//    @GetMapping("/tktk/{sotk}")
//        //Let's return an object with: data, message, status
//    ResponseEntity<ResponseObject> findBySotk(@PathVariable String sotk) {
//        Optional<Tktietkiem> foundProduct = tktietkiemRepository.findById(sotk);
//        return foundProduct.isPresent() ?
//                ResponseEntity.status(HttpStatus.OK).body(
//                        new ResponseObject("ok", "Query product successfully", foundProduct)
//                ):
//                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                        new ResponseObject("failed", "Cannot find product with id = "+sotk, "")
//                );
//    }
    @GetMapping("/getAll/{id}")
    public List<Tktietkiem> findByIdtktk(@PathVariable int id){
      return   tktietkiemService.findByIdtktk(id);
    }

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tkkh> updateContact(@PathVariable(value = "id") Integer id,@RequestBody Tkkh editUser) {
        Tkkh user = repository.getOne(id);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setTenkh(editUser.getTenkh());
        Tkkh updatedUser = repository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    @RequestMapping(value = "/tktk/update/{sotk}", method = RequestMethod.PUT)
    public ResponseEntity<Tktietkiem> updateContact1(@PathVariable Integer sotk,@RequestBody Tktietkiem editsotien) {
        Tktietkiem user = tktietkiemService.findbySotk(sotk);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setSotiengoc(editsotien.getSotiengoc());
        Tktietkiem updatedTktk = tktietkiemService.saveTktietkiem(user);
        return ResponseEntity.ok(updatedTktk);
    }
    @GetMapping("/tktt")
    public List<Tkthanhtoan> getAllTkthanhtoans() {
        return tkthanhtoanService.getAllTkthanhtoans();
    }
    @PostMapping("/tktk/add")
    public String add(@RequestBody Tktietkiem user){
        tktietkiemService.saveTktietkiem(user);
        return "New tktk is added";
    }
    @GetMapping("/tktt/{id}")
    public List<Tkthanhtoan> findByIdtktt(@PathVariable int id){
        return   tkthanhtoanService.findByIdtktt(id);
    }

    @RequestMapping(value = "/tktt/update/{sotk}", method = RequestMethod.PUT)
    public ResponseEntity<Tkthanhtoan> updateContact1(@PathVariable Integer sotk,@RequestBody Tkthanhtoan editsotien) {
        Tkthanhtoan user = tkthanhtoanService.findbySotk(sotk);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setSoducuoiky(editsotien.getSoducuoiky());
        Tkthanhtoan updatedTktt = tkthanhtoanService.saveTkthanhtoan(user);
        return ResponseEntity.ok(updatedTktt);
    }
    @PostMapping("/tktt/add")
    public String add(@RequestBody Tkthanhtoan user){
        tkthanhtoanService.saveTkthanhtoan(user);
        return "New tkthanhtoan is added";
    }
    //rút tiền đúng hạn
    @GetMapping("rutdunghan/{stk}/{stk_thanhtoan}")
    public void getEmployeeAge(@PathVariable int stk, @PathVariable int stk_thanhtoan){
         tktietkiemService.getEmployeeAge(stk,stk_thanhtoan);
    }
    //rút tien truoc ngay dao han
    @GetMapping("ruttruochan/{stk}/{stk_thanhtoan}")
    public void ruttientruocngaytattoan(@PathVariable int stk, @PathVariable int stk_thanhtoan){
        tktietkiemService.ruttientruocngaytattoan(stk,stk_thanhtoan);
    }
    //tái tục vốn
    @GetMapping("taitucvon/{stk}/{stk_thanhtoan}")
    public void taitucvon(@PathVariable int stk, @PathVariable int stk_thanhtoan){
        tktietkiemService.taitucvon(stk,stk_thanhtoan);
    }
    //tái tục vốn lẫn lãi
    @GetMapping("taitucvonlanlai/{stk}/{stk_thanhtoan}")
    public void taitucvonlanlai(@PathVariable int stk){
        tktietkiemService.taitucvonlanlai(stk);
    }
    //thống kê số tiền theo tháng
    @GetMapping("thongketheothang/{thang}/{nam}")
    public Float thongkesotientheothang(@PathVariable int thang,@PathVariable int nam ){
       return tktietkiemService.thongkesotientheothang(thang,nam);
    }
    //thống kê số tiền theo quý
    @GetMapping("thongketheoquy/{quy}/{nam}")
    public Float thongkesotientheoquy(@PathVariable int quy,@PathVariable int nam ){
        return tktietkiemService.thongkesotientheoquy(quy,nam);
    }
    //thống kê số tiền theo năm
    @GetMapping("thongketheonam/{nam}")
    public Float thongkesotientheonam(@PathVariable int nam ){
        return tktietkiemService.thongkesotientheonam(nam);
    }
    //thong ke tai khoan tk mới theo tháng
    @GetMapping("newuser/{thang}/{nam}")
    public List<Tktietkiem> getnewusertheothang(@PathVariable int thang,@PathVariable int nam ){
        return tktietkiemService.getnewusertheothang(thang,nam);
    }
    //thong ke tai khoan tk mới theo quý
    @GetMapping("newusertheoquy/{quy}/{nam}")
    public List<Tktietkiem> thongketaikhoanmoitheoquy(@PathVariable int quy,@PathVariable int nam ){
        return tktietkiemService.thongketaikhoanmoitheoquy(quy,nam);
    }
    //thong ke tai khoan tk mới theo quý
    @GetMapping("newusertheonam/{nam}")
    public List<Tktietkiem> thongketaikhoanmoitheonam(@PathVariable int nam ){
        return tktietkiemService.thongketaikhoanmoitheonam(nam);
    }


//    @RequestMapping(value = "/tktk/add", method = RequestMethod.POST)
//    public ResponseEntity<Tktietkiem> addtktk(@RequestBody Tktietkiem editsotien) {
//      tktietkiemService.saveTktietkiem(editsotien);
//        return ResponseEntity.ok(editsotien);
//    }
//    @PutMapping("/{id}")
//    ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User editUser) {
//        User updateUser = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ id));
//
//        updateUser.setTenkh(editUser.getTenkh());
//        updateUser.setEmailkh(editUser.getEmailkh());
//        updateUser.setDiachi(editUser.getDiachi());
//        final User updatedUser = repository.save(updateUser);
//        return ResponseEntity.ok(updatedUser);
//    }
    //insert new Product with POST method
    //Postman : Raw, JSON
//        @PostMapping("/insert")
//        ResponseEntity<ResponseObject> insertProduct(@RequestBody User newUser) {
//            //2 products must not have the same name !
//            List<User> foundProducts = repository.findByUserName(newUser.getTenkh().trim());
//            if(foundProducts.size() > 0) {
//                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                        new ResponseObject("failed", "Product name already taken", "")
//                );
//            }
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("ok", "Insert Product successfully", repository.save(newUser))
//            );
//        }
    //update, upsert = update if found, otherwise insert

//        ResponseEntity<ResponseObject> updateUser(@RequestBody User editUser, @PathVariable Integer id) {
//            User updateUser = repository.findById(id)
//                    .map(user -> {
//                        user.setTenkh(editUser.getTenkh());
//                        return repository.save(user);
//                    }).orElseGet(() -> {
//                        editUser.setId(id);
//                        return repository.save(editUser);
//                    });
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("ok", "Update Product successfully", updateUser)
//            );
//        }

    //Delete a Product => DELETE method
    @DeleteMapping("/user/delete/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Integer id) {
        boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find product to delete", "")
        );
    }
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        TkkhDetailsImpl tkkhDetails = (TkkhDetailsImpl) authentication.getPrincipal();
        List<String> roles = tkkhDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                tkkhDetails.getId(),
                tkkhDetails.getUsername(),
                tkkhDetails.getEmail(),
                tkkhDetails.getTenkh(),
                roles
                ));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signupRequest) {
        if (tkkhRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error:Username is already taken!!!"));
        }
        if (tkkhRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!!!"));
        }
        Tkkh tkkh = new Tkkh(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()),signupRequest.getCmnd_cccd(),
                signupRequest.getDiachi(),signupRequest.getGioitinh(),signupRequest.getNgaysinh(),signupRequest.getQuoctich(),signupRequest.getSdt(),signupRequest.getTenkh());
        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error:Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error:Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        tkkh.setRoles(roles);
        tkkhRepository.save(tkkh);
        return ResponseEntity.ok(tkkh);
      //  return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
