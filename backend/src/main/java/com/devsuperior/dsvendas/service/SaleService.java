package com.devsuperior.dsvendas.service;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccesDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;

    public SaleService(SaleRepository saleRepository, SellerRepository sellerRepository) {
        this.saleRepository = saleRepository;
        this.sellerRepository = sellerRepository;
    }

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccesDTO> succesGroupedBySeller() {
        return saleRepository.successGroupedBySeller();
    }
}
