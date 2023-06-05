package com.github.khanovmikhail.service;

import com.github.khanovmikhail.entity.Position;
import com.github.khanovmikhail.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.getAllPositions();
    }

    @Override
    public Position getPositionByName(String name) {
        return null;
    }

    @Override
    public boolean addNewPosition(String name) {
        return false;
    }

    @Override
    public boolean changeName(String oldName, String newName) {
        return false;
    }

    @Override
    public boolean deletePosition(String name) {
        return false;
    }
}
