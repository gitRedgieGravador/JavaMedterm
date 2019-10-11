/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamidterm;

/**
 *
 * @author gravadorre_sd2023
 */
public class Post {
    private String postedby;
    private String content;
    private String date;

    public Post(String postedby, String content, String date) {
        this.postedby = postedby;
        this.content = content;
        this.date = date;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "=====================================\n"
                + "Postedby: " + postedby + "\n" + content + "\nDate: " + date + 
                "\n=====================================\n";
    }
    
    
}
