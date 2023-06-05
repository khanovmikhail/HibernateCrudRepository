package com.github.khanovmikhail.repository;

import com.github.khanovmikhail.entity.Position;

import java.util.List;

public interface PositionRepository {
    List<Position> getAllPositions();
    Position getPositionByName(String name);
    boolean addNewPosition(String name);
    boolean changeName(String oldName, String newName);
    boolean deletePosition(String name);
}
