package com.example.modalclass;

public class StudentsModal
{
    String Name;
    int id;
    Double english,hindi,gujarati;

    void setName(String name){
        this.Name=name;

    }

    void setId(int id){
        this.id=id;

    }

    void setEnglish(Double english){
        this.english=english;
    }

    void setHindi(Double hindi){
        this.hindi=hindi;
    }

    void setGujarati(Double gujarati){
        this.gujarati=gujarati;
    }

    String getName(){
        return Name;
    }

    int getid(){
        return id;
    }

    Double getenglish(){
        return english;
    }

    Double gethindi(){
        return hindi;
    }

    Double getgujarati(){
        return gujarati;
    }
}
