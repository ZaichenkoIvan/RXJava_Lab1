package com.mycompany.model.services;

import com.mycompany.model.dao.InputDao;
import com.mycompany.model.entity.NotebookEntity;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Service
public class InputService {
    @Autowired
    private InputDao inputDao;
    public List<NotebookEntity> getAllNotebooks(){
        List<NotebookEntity> result = new ArrayList<>();
        int count = inputDao.getCountEntries();
        Scheduler scheduler = Schedulers.from(Executors.newFixedThreadPool(count));
        Observable.range(0, count)
                .flatMap(integer -> Observable.just(integer)
                        .map(i -> inputDao.getEntryForRXJava(i))
                        .subscribeOn(scheduler))
                .blockingForEach(result::add);
        return result;
    }
}
