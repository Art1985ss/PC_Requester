CREATE TABLE IF NOT EXISTS component (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(255) NOT NULL,
    name VARCHAR(255) UNIQUE NOT NULL,
    price DECIMAL(19 , 2 )
);

CREATE TABLE IF NOT EXISTS cooler (
    id BIGINT NOT NULL PRIMARY KEY,
    cooling_capacity INTEGER NOT NULL,
    FOREIGN KEY (id)
        REFERENCES component (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS cpu (
    id BIGINT NOT NULL PRIMARY KEY,
    core_count INTEGER NOT NULL,
    frequency DOUBLE NOT NULL,
    FOREIGN KEY (id)
        REFERENCES component (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS data_storage_device (
    id BIGINT NOT NULL PRIMARY KEY,
    capacity INTEGER NOT NULL,
    type VARCHAR(255),
    FOREIGN KEY (id)
        REFERENCES component (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS motherboard (
    id BIGINT NOT NULL PRIMARY KEY,
    ram_slots_count INTEGER NOT NULL,
    FOREIGN KEY (id)
        REFERENCES component (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS power_supply (
    id BIGINT NOT NULL PRIMARY KEY,
    capacity INTEGER NOT NULL,
    FOREIGN KEY (id)
        REFERENCES component (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ram (
    id BIGINT NOT NULL PRIMARY KEY,
    capacity INTEGER NOT NULL,
    FOREIGN KEY (id)
        REFERENCES component (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS video_card (
    id BIGINT NOT NULL PRIMARY KEY,
    gpu_speed INTEGER NOT NULL,
    FOREIGN KEY (id)
        REFERENCES component (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_table (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    justification VARCHAR(255),
    registration_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    state VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS order_components (
    order_id BIGINT,
    component_id BIGINT,
    FOREIGN KEY (order_id)
        REFERENCES order_table (id)
        ON DELETE CASCADE,
    FOREIGN KEY (component_id)
        REFERENCES component (id)
        ON DELETE CASCADE
);