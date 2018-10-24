package com.alexandr.demin.gitfollower.mvp.model.repository;

import com.alexandr.demin.gitfollower.mvp.model.entity.GitUser;
import com.alexandr.demin.gitfollower.mvp.model.entity.realm.RealmGitUser;
import com.alexandr.demin.gitfollower.utils.Constants;
import com.alexandr.demin.gitfollower.utils.RealmObjectParser;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class UserRepository {

    private static final String LOGIN_FIELD_NAME = "login";

    private RealmObjectParser parser;

    public UserRepository(RealmObjectParser parser) {
        this.parser = parser;
    }

    public Single<GitUser> getUser(String username) {
        return Single.create(emitter -> {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(innerRealm -> {
                RealmGitUser realmGitUser = getRealmUser(innerRealm, username);
                if (realmGitUser == null) {
                    emitter.onError(new RuntimeException(Constants.ERROR_NO_SUCH_USER));
                } else {
                    emitter.onSuccess(parser.parseToGitUser(realmGitUser));
                }
            });

            realm.close();
        });
    }

    public Single<List<GitUser>> getAllUsers() {
        return Single.create(emitter -> {
            Realm realm = Realm.getDefaultInstance();

            realm.executeTransaction(innerRealm -> {
                RealmResults<RealmGitUser> results = innerRealm.where(RealmGitUser.class).findAll();
                if (results == null) {
                    // TODO: 21.10.2018 add error
                }
                List<GitUser> users = new ArrayList<>();
                for (RealmGitUser result : results) {
                    users.add(parser.parseToGitUser(result));
                }
                emitter.onSuccess(users);
            });

            realm.close();
        });
    }

    public void putUser(GitUser user) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(innerRealm -> {
            RealmGitUser realmGitUser = getRealmUser(innerRealm, user.getLogin());
            if (realmGitUser == null) {
                realmGitUser = innerRealm.createObject(RealmGitUser.class, user.getLogin());
            }
            realmGitUser = parser.parseToRealmGitUser(user);
            innerRealm.copyToRealmOrUpdate(realmGitUser);
        });
        realm.close();
    }

    private RealmGitUser getRealmUser(Realm realm, String username) {
        return realm.where(RealmGitUser.class).equalTo(LOGIN_FIELD_NAME, username).findFirst();
    }

}
