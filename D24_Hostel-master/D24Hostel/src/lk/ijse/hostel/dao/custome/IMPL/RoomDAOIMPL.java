package lk.ijse.hostel.dao.custome.IMPL;

import lk.ijse.hostel.dao.custome.RoomDAO;
import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.RoomEntity;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RoomDAOIMPL implements RoomDAO {
    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public boolean save(RoomEntity entity) throws ConstraintViolationException {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;

        }
    }

    @Override
    public boolean update(RoomEntity entity) throws ConstraintViolationException {Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(entity);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(id);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    /*@Override
    public boolean deleted(RoomEntity entity) {
        return false;
    }*/

    @Override
    public RoomEntity search(String s) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            RoomEntity roomEntity=session.find(RoomEntity.class,s);
            transaction.commit();
            return new RoomEntity(s,roomEntity.getType(),roomEntity.getKey_money(), roomEntity.getQty());
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public List<RoomEntity> getAll() {
        /*Session session2=FactoryConfiguration.getInstance().getSession();
        String hql="From RoomEntity ";
        Query query= session2.createQuery(hql);
        List<RoomEntity> result=query.list();

        for (RoomEntity roomEntity:result) {
            roomEntity.getRoom_type_id();
            roomEntity.getType();
            roomEntity.getKey_money();
            roomEntity.getQty();

        }

        return result;*/
        List<RoomEntity> entities;
        try {
            Session session=FactoryConfiguration.getInstance().getSession();
            Query query=session.createQuery("from RoomEntity");
            entities=query.list();
            return  entities;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        /*Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        List<RoomEntity> entities=new ArrayList<>();

        try {
            Query query=session.createQuery("from RoomEntity ");
            List<RoomEntity> roomEntities=query.list();
            System.out.println(roomEntities);

            transaction.commit();
            return (ArrayList<RoomEntity>) roomEntities;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }*/

    }

    @Override
    public long calcAllRooms() {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        try {
            Long aLong=(Long) session.createQuery("SELECT COUNT (*) FROM RoomEntity ").getSingleResult();
            System.out.println(aLong);
            transaction.commit();
            return aLong;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return 0;
        }

    }

    @Override
    public ArrayList<String> loadRoomsIds() {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        List<RoomEntity> roomEntities=new ArrayList<>();

        try {
            Query query= session.createQuery("SELECT id from RoomEntity ");
            List<String> list=query.list();
            System.out.println(list);
            transaction.commit();
            return(ArrayList<String>) list;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }
}

