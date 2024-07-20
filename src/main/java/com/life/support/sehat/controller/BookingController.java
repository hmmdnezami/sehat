package com.life.support.sehat.controller;

import com.life.support.sehat.models.Booking;
import com.life.support.sehat.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @ResponseBody
    @RequestMapping(value = "/make-booking", method = RequestMethod.POST)
    public Booking makeBooking(@RequestBody Booking booking) {
        return bookingService.makeBooking(booking);
    }
}
