package ch.portfolio.portfoliobackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertbotController {
    @GetMapping("/.well-known/acme-challenge/bpLGgiBDvpYCxAQIPolEbg3Umdden7iI_wkbsxdLpU0")
    public String getCertbot() {
        return "bpLGgiBDvpYCxAQIPolEbg3Umdden7iI_wkbsxdLpU0.f12maOS0ZcAId6-b-tvxcCjitQNlM__-TKwEQwtVShk";
    }
}
