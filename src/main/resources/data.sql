INSERT INTO jomalone.attribute (id, maximum, minimum, mutability, name, supported, writable, step, created_at, modified_at) VALUES (1, 100, 0, 'rw', 'brightness', null, null, 10,'2021-12-02 00:08:20', '2021-12-02 00:08:18') ON DUPLICATE KEY UPDATE name='brightness';
INSERT INTO jomalone.attribute (id, maximum, minimum, mutability, name, supported, writable, step, created_at, modified_at) VALUES (2, null, null, 'rw', 'power', '["on", "off"]', '["on", "off"]', null,'2021-12-02 00:08:20', '2021-12-02 00:08:18') ON DUPLICATE KEY UPDATE name='power';
INSERT INTO jomalone.attribute (id, maximum, minimum, mutability, name, supported, writable, step, created_at, modified_at) VALUES (3, null, null, 'rw', 'colorMode', '["color", "colorTemperature"]', '["color", "colorTemperature"]', null,'2021-12-02 00:08:20', '2021-12-02 00:08:18') ON DUPLICATE KEY UPDATE name='colorMode';
INSERT INTO jomalone.attribute (id, maximum, minimum, mutability, name, supported, writable, step, created_at, modified_at) VALUES (4, null, null, 'rw', 'color', null, null, null,'2021-12-02 00:08:20', '2021-12-02 00:08:18') ON DUPLICATE KEY UPDATE name='color';
INSERT INTO jomalone.attribute (id, maximum, minimum, mutability, name, supported, writable, step, created_at, modified_at) VALUES (5, 3000, 5700, 'rw', 'colorTemperature', null, null, 100,'2021-12-02 00:08:20', '2021-12-02 00:08:18') ON DUPLICATE KEY UPDATE name='colorTemperature';

INSERT INTO jomalone.capability (id, created_at, modified_at, name) VALUES (1, '2021-12-02 00:08:20', '2021-12-02 00:08:18', 'Power') ON DUPLICATE KEY UPDATE name='Power';
INSERT INTO jomalone.capability (id, created_at, modified_at, name) VALUES (2, '2021-12-02 00:08:22', '2021-12-02 00:08:24', 'Brightness') ON DUPLICATE KEY UPDATE name='Brightness';
INSERT INTO jomalone.capability (id, created_at, modified_at, name) VALUES (3, '2021-12-02 00:08:25', '2021-12-02 00:08:27', 'ColorMode') ON DUPLICATE KEY UPDATE name='ColorMode';
INSERT INTO jomalone.capability (id, created_at, modified_at, name) VALUES (4, '2021-12-02 00:08:28', '2021-12-02 00:08:30', 'Color') ON DUPLICATE KEY UPDATE name='Color';
INSERT INTO jomalone.capability (id, created_at, modified_at, name) VALUES (5, '2021-12-02 00:08:32', '2021-12-02 00:08:34', 'ColorTemperature') ON DUPLICATE KEY UPDATE name='ColorTemperature';

INSERT INTO jomalone.device_type (id, created_at, modified_at, name, state) VALUES (1, '2021-12-02 00:13:47', '2021-12-02 00:13:49', 'Light', '{"power" : "on"}') ON DUPLICATE KEY UPDATE name='Light';
INSERT INTO jomalone.device_type (id, created_at, modified_at, name, state) VALUES (2, '2021-12-02 00:13:51', '2021-12-02 00:13:52', 'LightDimmer', '{"power": "on", "brightness": 50 }') ON DUPLICATE KEY UPDATE name='LightDimmer';
INSERT INTO jomalone.device_type (id, created_at, modified_at, name, state) VALUES (3, '2021-12-02 00:13:53', '2021-12-02 00:13:55', 'ColorLightDimmer', '{"power": "on", "brightness": 50, "colorMode": "color", "color": "#FFFFFF", "colorTemperature": 5000}') ON DUPLICATE KEY UPDATE name='ColorLightDimmer';

INSERT INTO jomalone.capability_attribute (id, created_at, modified_at, attribute_id, capability_id) VALUES (1, '2021-12-02 00:11:11', '2021-12-02 00:11:14', 2, 1) ON DUPLICATE KEY UPDATE capability_id=1;
INSERT INTO jomalone.capability_attribute (id, created_at, modified_at, attribute_id, capability_id) VALUES (2, '2021-12-02 00:11:16', '2021-12-02 00:11:17', 1, 2) ON DUPLICATE KEY UPDATE capability_id=2;
INSERT INTO jomalone.capability_attribute (id, created_at, modified_at, attribute_id, capability_id) VALUES (3, '2021-12-02 00:11:18', '2021-12-02 00:11:20', 3, 3) ON DUPLICATE KEY UPDATE capability_id=3;
INSERT INTO jomalone.capability_attribute (id, created_at, modified_at, attribute_id, capability_id) VALUES (4, '2021-12-02 00:11:21', '2021-12-02 00:11:22', 4, 4) ON DUPLICATE KEY UPDATE capability_id=4;
INSERT INTO jomalone.capability_attribute (id, created_at, modified_at, attribute_id, capability_id) VALUES (5, '2021-12-02 00:11:23', '2021-12-02 00:11:25', 5, 5) ON DUPLICATE KEY UPDATE capability_id=5;

INSERT INTO jomalone.device_type_capability (id, created_at, modified_at, capability_id, device_type_id) VALUES (1, '2021-12-02 00:15:13', '2021-12-02 00:15:14', 1, 1) ON DUPLICATE KEY UPDATE capability_id=1;
INSERT INTO jomalone.device_type_capability (id, created_at, modified_at, capability_id, device_type_id) VALUES (2, '2021-12-02 00:15:15', '2021-12-02 00:15:16', 1, 2) ON DUPLICATE KEY UPDATE capability_id=1;
INSERT INTO jomalone.device_type_capability (id, created_at, modified_at, capability_id, device_type_id) VALUES (3, '2021-12-02 00:15:18', '2021-12-02 00:15:19', 2, 2) ON DUPLICATE KEY UPDATE capability_id=2;
INSERT INTO jomalone.device_type_capability (id, created_at, modified_at, capability_id, device_type_id) VALUES (4, '2021-12-02 00:15:20', '2021-12-02 00:15:21', 1, 3) ON DUPLICATE KEY UPDATE capability_id=1;
INSERT INTO jomalone.device_type_capability (id, created_at, modified_at, capability_id, device_type_id) VALUES (5, '2021-12-02 00:15:23', '2021-12-02 00:15:24', 2, 3) ON DUPLICATE KEY UPDATE capability_id=2;
INSERT INTO jomalone.device_type_capability (id, created_at, modified_at, capability_id, device_type_id) VALUES (6, '2021-12-02 00:15:25', '2021-12-02 00:15:26', 3, 3) ON DUPLICATE KEY UPDATE capability_id=3;
INSERT INTO jomalone.device_type_capability (id, created_at, modified_at, capability_id, device_type_id) VALUES (7, '2021-12-02 00:15:27', '2021-12-02 00:15:28', 4, 3) ON DUPLICATE KEY UPDATE capability_id=4;
INSERT INTO jomalone.device_type_capability (id, created_at, modified_at, capability_id, device_type_id) VALUES (8, '2021-12-02 00:15:29', '2021-12-02 00:15:30', 5, 3) ON DUPLICATE KEY UPDATE capability_id=5;
