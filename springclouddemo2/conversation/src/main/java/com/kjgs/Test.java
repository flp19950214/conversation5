package com.kjgs;

import com.kjgs.枚举.Cons;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Test {
    public static void main(String[] args) {
//        Document document = new Document();
//        String s = document.get(Cons._id).toString();
//        Document document2 = new Document();
//        String s2 = document2.get(Cons._id).toString();
        ObjectId objectId1 = new ObjectId();
        ObjectId objectId2 = new ObjectId();
        System.out.println(objectId2.compareTo(objectId1));
    }
}
