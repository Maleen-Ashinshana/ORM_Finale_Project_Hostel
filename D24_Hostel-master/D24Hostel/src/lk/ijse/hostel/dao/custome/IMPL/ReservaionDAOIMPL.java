package lk.ijse.hostel.dao.custome.IMPL;

import lk.ijse.hostel.dao.custome.ReservationDAO;
import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.ReservationEntity;
import lk.ijse.hostel.entity.RoomEntity;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservaionDAOIMPL implements ReservationDAO {
    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public boolean save(ReservationEntity entity) throws ConstraintViolationException {
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
    public boolean update(ReservationEntity entity) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
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
    public boolean deleted(ReservationEntity entity) {
        return false;
    }*/

    @Override
    public ReservationEntity search(String s) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            ReservationEntity entity=session.find(ReservationEntity.class,s);
            transaction.commit();
            return new ReservationEntity(s, entity.getDate(), entity.getStatus());
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public List<ReservationEntity> getAll() {

        List<ReservationEntity> list;
        try {
             Session session = FactoryConfiguration.getInstance().getSession();
            Query query = session.createQuery("from ReservationEntity ");
            list=query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
