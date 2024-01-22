package org.example;

public interface IChisteDao {
    public String getRandomJoke();

    public String getChisteByLang(String lang);
    public String getChisteByCategory(String cat);
}
