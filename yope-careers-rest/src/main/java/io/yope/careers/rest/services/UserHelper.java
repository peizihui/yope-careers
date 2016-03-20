/**
 *
 */
package io.yope.careers.rest.services;

import org.springframework.beans.factory.annotation.Autowired;

import io.yope.careers.domain.Page;
import io.yope.careers.domain.Title;
import io.yope.careers.domain.User;
import io.yope.careers.service.QueryCriteria;
import io.yope.careers.service.UserService;

/**
 * @author Massimiliano Gerardi
 *
 */
public class UserHelper {

    @Autowired
    private BlockchainService blockchainService;

    @Autowired
    private UserService userService;

    public User register(final User user) {
        final String hash = this.blockchainService.register(user);
        final User currentUser = this.userService.register(user.withHash(hash));
        return currentUser;
    }

    public Page<User> search(final QueryCriteria query) {
        return this.userService.search(query);
    }

    public User get(final String id) {
        return this.userService.get(id);
    }

    public User modify(final String id, final User candidate) {
        return this.userService.modify(id, candidate);
    }

    public User delete(final String id) {
        return this.userService.delete(id);
    }

    public Page<Title> getTitle(final String id) {
        return this.userService.getTitles(id);
    }


}