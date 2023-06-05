package com.github.khanovmikhail.service;

import com.github.khanovmikhail.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();
    Position getPositionByName(String name);
    boolean addNewPosition(String name);
    boolean changeName(String oldName, String newName);
    boolean deletePosition(String name);
}
