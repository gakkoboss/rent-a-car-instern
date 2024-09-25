package com.kadirsancar.rent_a_car_instern.controller;

import com.kadirsancar.rent_a_car_instern.dto.InvoiceDto;
import com.kadirsancar.rent_a_car_instern.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {


    private final InvoiceService invoiceService;

    @GetMapping
    public List<InvoiceDto> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable Long id) {
        Optional<InvoiceDto> invoiceDto = invoiceService.getInvoiceById(id);
        return invoiceDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto) {
        //return invoiceService.saveInvoice(invoiceDto);
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDto> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDto invoiceDto) {
        if (!invoiceService.getInvoiceById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.ok(invoiceService.saveInvoice(invoiceDto));
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        if (!invoiceService.getInvoiceById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}
