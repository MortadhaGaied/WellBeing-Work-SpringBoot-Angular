package com.wellbeignatwork.backend.Controller;

import com.sun.mail.iap.Response;
import com.wellbeignatwork.backend.ServiceImp.IUsersOfferService;
import com.wellbeignatwork.backend.model.Feedback;
import com.wellbeignatwork.backend.model.Offer;
import com.wellbeignatwork.backend.model.OfferFeedbacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class UsersOfferController {
    @Autowired
    IUsersOfferService usersOfferService;

    @PutMapping("/add-offer-fav")
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Response addFav(@RequestParam Long offerId, Long userId) {
        try {
            /*UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();
            Long userId = currentUser.getId();*/
            usersOfferService.addOfferToFav(userId, offerId);
            return new Response("Offer is added successfully to your favorite list", true);
        } catch (Exception e) {
            return new Response(e.getMessage(), false);
        }
    }

    @GetMapping("/get-offers-fav")
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Offer> getFav(Long userId) {
        /*UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = currentUser.getId();*/
        return usersOfferService.getFavOffer(userId);
    }

    @GetMapping("/get-invited-offers")
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Offer> getInvited(Long userId) {
        /*UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = currentUser.getId();*/
        return usersOfferService.getInvitedOffers(userId);
    }

    @PutMapping("/feedback-offer")
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Response feedbackOffer(@RequestParam Long offerId, @Valid @RequestBody Feedback feedback, Long userId) {
        try {
            /*UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();
            Long userId = currentUser.getId();*/
            usersOfferService.feedbackOffer(userId, offerId, feedback);
            return new Response("Thank you for your feedback", true);
        } catch (Exception e) {
            return new Response(e.getMessage(), false);
        }
    }

    @GetMapping("/avg-rating")
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Object getAverageRatingOffer(@RequestParam Long offerId) {
        try {
            return Map.of("average", usersOfferService.getAverageRateOffer(offerId));
        } catch (Exception e) {
            return new Response(e.getMessage(), false);
        }
    }

    @GetMapping("/get-offer-feedbacks")
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<OfferFeedbacks> getOfferFeedbacks(@RequestParam Long offerId) {
        return usersOfferService.getFeedbackOffer(offerId);
    }
}
