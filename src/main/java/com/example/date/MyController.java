package com.example.date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class MyController {
    @GetMapping("/")
    public String localdate() {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDateTime = dateObj.format(formatter1);
        return formattedDateTime;
    }

}