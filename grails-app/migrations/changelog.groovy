databaseChangeLog = {

    changeSet(author: "luis (generated)", id: "1350868042376-1") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "luis (generated)", id: "1350868042376-2") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "luis (generated)", id: "1350868042376-3") {
        createTable(tableName: "user_role") {
            column(name: "role_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "luis (generated)", id: "1350868042376-4") {
        addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "luis (generated)", id: "1350868042376-5") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A655C625A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
    }

    changeSet(author: "luis (generated)", id: "1350868042376-6") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46AA87263A", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    changeSet(author: "luis (generated)", id: "1350868042376-7") {
        createIndex(indexName: "authority_unique_1350868042295", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "luis (generated)", id: "1350868042376-8") {
        createIndex(indexName: "username_unique_1350868042311", tableName: "user", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "luis (generated)", id: "1350868042376-9") {
        createIndex(indexName: "FK143BF46A655C625A", tableName: "user_role") {
            column(name: "role_id")
        }
    }

    changeSet(author: "luis (generated)", id: "1350868042376-10") {
        createIndex(indexName: "FK143BF46AA87263A", tableName: "user_role") {
            column(name: "user_id")
        }
    }

    include file: 'add-default-users.groovy'
}

