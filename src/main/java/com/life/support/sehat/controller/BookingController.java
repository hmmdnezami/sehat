package com.life.support.sehat.controller;

import com.life.support.sehat.models.Booking;
import com.life.support.sehat.service.BookingService;
import com.life.support.sehat.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FareService fareService;

    @ResponseBody
    @RequestMapping(value = "/make-booking", method = RequestMethod.POST)
    public Booking makeBooking(@RequestBody Booking booking) {
        return bookingService.makeBooking(booking);
    }

    @ResponseBody
    @RequestMapping(value = "/calculate-fare", method = RequestMethod.POST)
    public int calculateFare(@RequestParam int duration, @RequestParam int distance) {
        return fareService.calculateExpectedFare(duration, distance);
    }
}
