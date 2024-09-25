package com.kadirsancar.rent_a_car_instern.service;

import com.kadirsancar.rent_a_car_instern.dto.InvoiceDto;
import com.kadirsancar.rent_a_car_instern.mapper.InvoiceMapper;
import com.kadirsancar.rent_a_car_instern.model.Car;
import com.kadirsancar.rent_a_car_instern.model.Invoice;
import com.kadirsancar.rent_a_car_instern.model.User;
import com.kadirsancar.rent_a_car_instern.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;

    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream()
                .map(invoiceMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<InvoiceDto> getInvoiceById(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.map(invoiceMapper::toDto);
    }

    public Invoice saveInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDto);
        return invoiceRepository.save(invoice);
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
    }


