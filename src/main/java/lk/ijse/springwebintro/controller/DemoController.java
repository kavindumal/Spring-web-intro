package lk.ijse.springwebintro.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Map;

@RequestMapping("api/v1/demo")
@RestController
public class DemoController {
    @GetMapping(value = "/pattern/{name}")
    public String pathVariable(@PathVariable("name") String name) {
        return "DemoController run perfectly with :" + name;
    }

    @GetMapping(value = "/patternRegex/{id:C\\d{3}}")
    public String pathVariableWithRegex(@PathVariable("id") String id) {
        return "DemoController run perfectly with:" + id;
    }

    @GetMapping(value = "/patternRegex/{id:C\\d{3}}", headers = "X-number")
    public String pathVariableWithRegexAndHeader(@PathVariable("id") String id, @RequestHeader("X-number") int num) {
        return "Path variable is : " + id + " and header is : " + num;
    }

    @GetMapping(params = "/test=all")
    public String test() {
        return "All are tested";
    }

    @PostMapping(params = {"name", "quantity"})
    public String paramData(@RequestParam("name") String param01,@RequestParam("quantity") String param02) {
        return "Param Data is" + param01 + "and" + param02;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveJSON() {
        return "Save JSON";
    }

    @PostMapping("/dynamic/{value:\\d{3}}")
    public ResponseEntity<String> returnDynamicData(@PathVariable("value") int incomingValue) {
        if (incomingValue % 2 == 0) {
            return ResponseEntity.ok("Dynamic Data is even");
        }
        return ResponseEntity.ok("Dynamic Data is odd");
    }

    @PostMapping(value = "/mapparams",params = {"id", "desc"})
    public String handleMaps(@RequestParam("id") String id,@RequestParam("desc") String desc, @RequestParam Map<String, String> params) {
        System.out.println(params);
        return "Handle Maps with params " + params;
    }
}