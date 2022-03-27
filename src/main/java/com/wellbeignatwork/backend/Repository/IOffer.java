package com.wellbeignatwork.backend.Repository;


import com.wellbeignatwork.backend.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOffer extends JpaRepository<Offer, Long> {

     Optional<Offer> findByIdOffer(int id);
     List<Offer> findAll();
    void inviteUsersToOffer(List<Long> usersId, Long offerId);
    }
