#include <stdlib.h>
#include "sensor.h"

Sensor * allocate_memory_sensors(int size) {
    if (size > 0) {
    Sensor * sensor_type = (Sensor *) malloc(size * sizeof(Sensor));
    return sensor_type;
}
    return NULL;
}