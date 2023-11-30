package com.youcode.mypromotionapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PromotionService <o>{
    Optional<o> create(o o);
    Optional<o> read(UUID uuid);
    List<o> readAll();
    Optional<o> update(o o);
    boolean delete(UUID uuid);
}
