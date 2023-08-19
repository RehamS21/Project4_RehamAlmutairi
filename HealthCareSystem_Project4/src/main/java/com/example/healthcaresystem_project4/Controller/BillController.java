package com.example.healthcaresystem_project4.Controller;

import com.example.healthcaresystem_project4.Api.ApiResponse;
import com.example.healthcaresystem_project4.Model.Bill;
import com.example.healthcaresystem_project4.Service.BillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bill")
@RequiredArgsConstructor
public class BillController {
    private final BillService billService;

    @GetMapping("/get")
    public ResponseEntity getAllBills(){
        return ResponseEntity.status(200).body(billService.getAllBill());
    }

    @PostMapping("/add")
    public ResponseEntity addNewBill(@RequestBody @Valid Bill bill){
        billService.addBill(bill);
        return ResponseEntity.status(200).body(new ApiResponse("the bill added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBill(@PathVariable Integer id, @RequestBody @Valid Bill bill){
        billService.updateBill(id,bill);
        return ResponseEntity.status(200).body(new ApiResponse("the bill updated info successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBill(@PathVariable Integer id){
        billService.deleteBill(id);
        return ResponseEntity.status(200).body(new ApiResponse("The bill deleted successfully"));
    }

    @PutMapping("/calc/{id}")
    public ResponseEntity clculateBills(@PathVariable Integer id){
        Integer result = billService.calculateBill(id);
        return ResponseEntity.status(200).body(new ApiResponse("The Paitent money after the calcultation of the bill = "+result));
    }

    @PutMapping("/discount/{id}")
    public ResponseEntity dicountPaitnetBill(@PathVariable Integer id){
        Integer result = billService.DiscountBill(id);

        return ResponseEntity.status(200).body(new ApiResponse("The bill after discount = "+result));
    }

}
