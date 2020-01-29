package de.qaware.cockroach.demo.integration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

/**
 * Allows us to use UUID type in columns of SQL tables and in JPA column member fields.
 * This class seems to be unnecessary but it is not, otherwise JPA can not cope with UUIDs.
 */
@Converter(autoApply = true)
public class UuidConverter implements AttributeConverter<UUID, UUID> {

    @Override
    public UUID convertToDatabaseColumn(UUID attribute) {
        return attribute;
    }

    @Override
    public UUID convertToEntityAttribute(UUID dbData) {
        return dbData;
    }
}