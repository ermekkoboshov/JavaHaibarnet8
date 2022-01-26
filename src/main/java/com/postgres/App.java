package com.postgres;

import com.postgres.entity.Workers;
import com.postgres.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {


        saveUser("Ermek", "koboshov", "it ", 20);
        saveUser("Aza", "Muratov", "zavot ", 17);
        saveUser("Aza", "Ergesov", "firma ", 25);
        saveUser("Aza", "Asanov", "povar", 30);


//        create();
//getAllStudent();
//        updateAza(18,"Aza");
//        removeAza();

        
    }

    public static void create() {
        Workers worker = new Workers();
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(worker);
        session.getTransaction().commit();
        session.close();
        System.out.println("baza dannyh koshuldu");
    }

    public static void saveUser(String name, String surname, String workers, int age) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Workers worker = new Workers(name, surname, workers, age);
        session.save(worker);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Workers> getAllStudent() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Workers> workers = session.createQuery("from Workers where age > 20 and name ='Aza'").getResultList();
        session.getTransaction().commit();
        System.out.println("get");
        session.close();
        return workers;
    }
    public static void updateAza(int age,String name){
        Session session=HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.createQuery("UPDATE Workers  set age=:age where name=:name").
                setParameter("age",age).setParameter("name",name).executeUpdate();
        session.getTransaction().commit();
        System.out.println("update");
        session.close();

    }
    public static void removeAza(){
        Session session=HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from Workers where name='Aza'").executeUpdate();
        System.out.println("Delete");
        session.close();
    }
}





