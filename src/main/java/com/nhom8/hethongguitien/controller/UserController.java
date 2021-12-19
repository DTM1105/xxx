//package com.nhom8.hethongguitien.controller;
//import com.nhom8.hethongguitien.model.ResponseObject;
//import com.nhom8.hethongguitien.model.User;
//import com.nhom8.hethongguitien.repository.UserRepository;
//import com.nhom8.hethongguitien.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//@RestController
//@RequestMapping("/user")
//@CrossOrigin
//public class UserController {
////    @Autowired
////    private UserService userService ;
////    private UserRepository userRepository;
////
////
////    @PostMapping("/add")
////    public String add(@RequestBody User user){
////        userService.saveUser(user);
////        return "New user is added";
////    }
////    @PutMapping("/update")
////    public String update(@RequestBody User user){
////        userService.saveUser(user);
////        return "User updated";
////    }
////    @GetMapping("/getAll")
////    public List<User> getAllUsers(){
////        return userService.getAllUsers();
////    }
////    @GetMapping("/getAll/{id}")
////    public List<User> findById(@PathVariable int id){
////      return   userService.findById(id);
////    }
////    @PutMapping("/update/{id}")
////    public ResponseEntity<ResponseObject> updateUser(@RequestBody User editUser, @PathVariable Integer id) {
////        User updateUser = userRepository.findById(id).map(
////                user -> {
////                    user.setTenkh(editUser.getTenkh());
////                    return userRepository.save(user);
////                }).orElseGet(()->{
////                    editUser.setId(id);
////                    return userRepository.save(editUser);
////        });
////        return ResponseEntity.status((HttpStatus.OK) ).body(new ResponseObject("ok","Update Product successfully",updateUser));
////    }
//////
////DI = Dependency Injection
//        @Autowired
//        private UserRepository repository;
//        @GetMapping("")
//            //this request is: http://localhost:8080/api/v1/Products
//        public List<User> getAllUsers() {
//                return repository.findAll();
//
//        }
//
//        //Get detail product
//        @GetMapping("/{id}")
//        //Let's return an object with: data, message, status
//        ResponseEntity<ResponseObject> findById(@PathVariable Integer id) {
//            Optional<User> foundProduct = repository.findById(id);
//            return foundProduct.isPresent() ?
//                    ResponseEntity.status(HttpStatus.OK).body(
//                            new ResponseObject("ok", "Query product successfully", foundProduct)
//                            //you can replace "ok" with your defined "error code"
//                    ):
//                    ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                            new ResponseObject("failed", "Cannot find product with id = "+id, "")
//                    );
//        }
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateContact(@PathVariable(value = "id") Integer id,@RequestBody User editUser) {
//        User user = repository.getOne(id);
//        if(user == null) {
//            return ResponseEntity.notFound().build();
//        }
//        user.setTenkh(editUser.getTenkh());
//        User updatedUser = repository.save(user);
//        return ResponseEntity.ok(updatedUser);
//    }
////    @PutMapping("/{id}")
////    ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User editUser) {
////        User updateUser = repository.findById(id)
////                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ id));
////
////        updateUser.setTenkh(editUser.getTenkh());
////        updateUser.setEmailkh(editUser.getEmailkh());
////        updateUser.setDiachi(editUser.getDiachi());
////        final User updatedUser = repository.save(updateUser);
////        return ResponseEntity.ok(updatedUser);
////    }
//        //insert new Product with POST method
//        //Postman : Raw, JSON
////        @PostMapping("/insert")
////        ResponseEntity<ResponseObject> insertProduct(@RequestBody User newUser) {
////            //2 products must not have the same name !
////            List<User> foundProducts = repository.findByUserName(newUser.getTenkh().trim());
////            if(foundProducts.size() > 0) {
////                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
////                        new ResponseObject("failed", "Product name already taken", "")
////                );
////            }
////            return ResponseEntity.status(HttpStatus.OK).body(
////                    new ResponseObject("ok", "Insert Product successfully", repository.save(newUser))
////            );
////        }
//        //update, upsert = update if found, otherwise insert
//
////        ResponseEntity<ResponseObject> updateUser(@RequestBody User editUser, @PathVariable Integer id) {
////            User updateUser = repository.findById(id)
////                    .map(user -> {
////                        user.setTenkh(editUser.getTenkh());
////                        return repository.save(user);
////                    }).orElseGet(() -> {
////                        editUser.setId(id);
////                        return repository.save(editUser);
////                    });
////            return ResponseEntity.status(HttpStatus.OK).body(
////                    new ResponseObject("ok", "Update Product successfully", updateUser)
////            );
////        }
//
//        //Delete a Product => DELETE method
//        @DeleteMapping("/{id}")
//        ResponseEntity<ResponseObject> deleteProduct(@PathVariable Integer id) {
//            boolean exists = repository.existsById(id);
//            if(exists) {
//                repository.deleteById(id);
//                return ResponseEntity.status(HttpStatus.OK).body(
//                        new ResponseObject("ok", "Delete product successfully", "")
//                );
//            }
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                    new ResponseObject("failed", "Cannot find product to delete", "")
//            );
//        }
//    }