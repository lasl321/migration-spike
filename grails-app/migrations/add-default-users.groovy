databaseChangeLog = {
    changeSet(author: 'luis', id: 'add-default-users-1') {
        grailsChange {
            change {
                sql.execute("INSERT INTO `role` VALUES (NULL, 0, 'ROLE_ADMIN')")
            }

            rollback {
                sql.execute("DELETE FROM `role` where authority='ROLE_ADMIN'")
            }
        }
    }

    changeSet(author: 'luis', id: 'add-default-users-2') {
        grailsChange {
            change {
                sql.execute("")
            }

            rollback {
                sql.execute("DELETE FROM `role` where authority='ROLE_USER'")
            }
        }
    }

    changeSet(author: 'luis', id: 'add-default-users-3') {
        grailsChange {
            change {
                sql.execute("INSERT INTO user VALUES (NULL, 0, 0, 0, 1, PASSWORD('password#1'), 0, 'user');")
            }

            rollback {
                sql.execute("DELETE FROM user WHERE username='user'")
            }
        }
    }

    changeSet(author: 'luis', id: 'add-default-users-4') {
        grailsChange {
            change {
                sql.execute("INSERT INTO user VALUES (NULL, 0, 0, 0, 1, PASSWORD('password#1'), 0, 'admin');")
            }

            rollback {
                sql.execute("DELETE FROM user WHERE username='admin'")
            }
        }
    }

    changeSet(author: 'luis', id: 'add-default-users-5') {
        grailsChange {
            change {
                sql.execute("insert into user_role select r.id, u.id from role as r, user as u where r.authority='ROLE_USER' and u.username='user'")
            }

            rollback {
                sql.execute("DELETE FROM user WHERE username='admin'")
            }
        }
    }

    changeSet(author: 'luis', id: 'add-default-users-6') {
        grailsChange {
            change {
                sql.execute("INSERT INTO user VALUES (NULL, 0, 0, 0, 1, PASSWORD('password#1'), 0, 'admin');")
            }

            rollback {
                sql.execute("DELETE FROM user WHERE username='admin'")
            }
        }
    }

    changeSet(author: 'luis', id: 'add-default-users-7') {
        grailsChange {
            change {
                sql.execute("INSERT INTO user VALUES (NULL, 0, 0, 0, 1, PASSWORD('password#1'), 0, 'admin');")
            }

            rollback {
                sql.execute("DELETE FROM user WHERE username='admin'")
            }
        }
    }
}

