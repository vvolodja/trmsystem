package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.dao.SpecialistDAO;
import com.cbsgenesis.trmsystem.model.Specialist;
import com.cbsgenesis.trmsystem.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link SpecialistService} interface
 *
 * @author Dmitriy Saltykov
 */

@Service
public class SpecialistServiceImpl implements SpecialistService {

        @Autowired
        private SpecialistDAO specialistDao;

        /**
         * @return
         */
        @Override
        @Transactional
        public Collection<Specialist> getAll() {
            return specialistDao.getAll();
        }

        /**
         * @param specialist
         */
        @Override
        @Transactional
        public void save(Specialist specialist) {
            specialistDao.save(specialist);
        }

        /**
         * @param specialist
         */
        @Override
        @Transactional
        public void delete(Specialist specialist) {
            specialistDao.delete(specialist);
        }

        /**
         *
         * @param id
         * @return
         */
        @Override
        @Transactional
        public Specialist getById(UUID id) {
            return specialistDao.getById(id);
        }

        /**
         *
         * @param lastName
         * @return
         */
        @Override
        @Transactional
        public Specialist findByLastName (String lastName) {
            return specialistDao.findByName(lastName);
        }

}
