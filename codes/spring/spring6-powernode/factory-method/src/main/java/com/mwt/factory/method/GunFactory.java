package com.mwt.factory.method;

public class GunFactory extends WeaponFactory {
    @Override
    public Weapon get() {
        return new Gun();
    }
}
