package com.mycompany.model.services;

import com.mycompany.model.dao.OutputDao;
import com.mycompany.model.entity.NotebookEntity;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class OutputService {
    @Autowired
    private OutputDao outputDao;

    public void addNotebook(List<NotebookEntity> notebooks) {
        Executor executor = Executors.newSingleThreadExecutor();
        Scheduler scheduler = Schedulers.from(executor);
        Observable.range(0, notebooks.size())
                .flatMap(i -> Observable.just(notebooks.get(i))
                        .map(entryModel -> {
                            outputDao.addNotebook(entryModel);
                            return entryModel;
                        })
                        .subscribeOn(scheduler));
    }
}
