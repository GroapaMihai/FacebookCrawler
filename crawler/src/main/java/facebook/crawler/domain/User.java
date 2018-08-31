package facebook.crawler.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "define.user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "url")
    private String url;

    @Column(name = "last_cloning_time")
    private Timestamp lastCloningTime;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getLastCloningTime() {
        return lastCloningTime;
    }

    public void setLastCloningTime(Timestamp lastCloningTime) {
        this.lastCloningTime = lastCloningTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(url, user.url) &&
                Objects.equals(lastCloningTime, user.lastCloningTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, url, lastCloningTime);
    }
}
