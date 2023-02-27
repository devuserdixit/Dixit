package com.example.modalclasswithadapter;

public class ModalClassActivity {

    String contactname;
    int personid;

    public void setId(int id)
    {
        personid=id;
    }

    void setcontactname(String contactname)
    {
        this.contactname = contactname;
    }

    int getid()
    {
        return personid;
    }

    public String getContactname()
    {
        return contactname;
    }
}
