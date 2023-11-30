package com.youcode.mypromotionapi.services;

import java.util.Optional;

// Will be implemented by General Administrator
public interface AdministratorLogin<O> {
    Optional<O> login(O o);
}
