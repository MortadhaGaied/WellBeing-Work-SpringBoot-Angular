package com.wellbeignatwork.backend.API;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.wellbeignatwork.backend.Repository.IReservationRepository;
import com.wellbeignatwork.backend.Repository.UserRepository;
import com.wellbeignatwork.backend.model.Payment;
import com.wellbeignatwork.backend.model.Reservation;
import com.wellbeignatwork.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    IReservationRepository reservationRepository;

    @Value("sk_test_51Khl7ZAmmAEwNuySJwTRMgb230wvzoZdIK2y9TshyH9zw23VcRLJtZFu9X3oL4CHhPUUjdnwFZKs7i3GCsLYaAhI00CeUoUGzp")
    String stripeKey;

    public Payment payment(long idUser,long idReservation , Payment p) throws StripeException {
        Stripe.apiKey= stripeKey;
        User user = userRepository.findById(idUser).get();
        Reservation reservation = reservationRepository.findById(idReservation).get();
        Map<String, Object> params = new HashMap<>();
        params.put("name",user.getName());
        params.put("email",user.getEmail());
        params.put("price",reservation.getPriceTotal());
        params.put("Title",reservation.getOffersRes().getTitle());
        //params.put("created",p.getCreated());
        Customer customer = Customer.create(params);
        p.setCustomerId(customer.getId());
        return p;
    }



}
