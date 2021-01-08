package com.epam.web.service;

import com.epam.web.entity.Promotion;

import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface PromotionService {

    List<Promotion> getPromotions() throws ServiceException;

    void savePromotion(Promotion promotion) throws ServiceException;

    void deletePromotion(Long id) throws ServiceException;

    Optional<Promotion> getPromotionById(Long id) throws ServiceException;
}
