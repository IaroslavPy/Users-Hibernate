package org.example.app.repositories;

import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserUpdateRepository {

    public String updateUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакция стартует
            transaction = session.beginTransaction();

            String hql = "UPDATE User SET phone = :phone WHERE id = :id";
            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("phone", user.getPhone());
            query.setParameter("id", user.getId());
            query.executeUpdate();
            // Транзакция выполняется
            transaction.commit();
            return Constants.DATA_UPDATE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
