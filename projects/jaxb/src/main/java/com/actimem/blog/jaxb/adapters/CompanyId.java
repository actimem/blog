package com.actimem.blog.jaxb.adapters;

public class CompanyId {
    private final String id;

    public CompanyId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyId)) return false;
        CompanyId companyId = (CompanyId) o;
        return id.equals(companyId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
