package com.qjx.pojo;

import java.util.Objects;

public class TEnInv extends TEnInvKey {
    private Integer regcap;

    private Integer scale;

    public Integer getRegcap() {
        return regcap;
    }

    public void setRegcap(Integer regcap) {
        this.regcap = regcap;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "TEnInv{" +
                "regcap=" + regcap +
                ", scale=" + scale + ", orgcode=" + super.getOrgcode() + "invregnum=" + super.getInvregnum() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TEnInv tEnInv = (TEnInv) o;
        return Objects.equals(regcap, tEnInv.regcap) &&
                Objects.equals(scale, tEnInv.scale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regcap, scale);
    }
}