package com.github.khanovmikhail.controller;

import com.github.khanovmikhail.entity.Position;
import com.github.khanovmikhail.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/{name}")
    public Position getPositionByName(@PathVariable String name) {
        return positionService.getPositionByName(name);
    }

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping
    public ResponseEntity<?> createPosition(@RequestParam String name) {
        positionService.addNewPosition(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> modifyPosition(@PathVariable String name,
                                            @RequestParam String newName) {
        positionService.changeName(name, newName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> removePosition(@PathVariable String name) {
        positionService.deletePosition(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
