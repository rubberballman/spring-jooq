package fred.custom.crm.core.model;

/**
 * This interface must be implemented by all domain class.
 * 
 * @param <K>
 *            K is the entity's key type
 * @author Fred
 */
public interface BaseEntity<K> {

    /**
     * @return the Id of this entity
     */
    K getId();

    /**
     * @param key
     *            Key is the entity's primary database key
     */
    void setId(K key);

    /**
     * The field call by this getter must have @Version annotation
     * 
     * @return Version
     */
    int getVersion();
}