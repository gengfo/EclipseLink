/*******************************************************************************
 * Copyright (c) 1998, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *              James Sutherland - initial example
 ******************************************************************************/
package gengfo.eclipselink.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Represents an employee's job title.
 */
@Entity
public class JobTitle implements Serializable {
    @Id
    @Column(name = "JOB_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Basic
    private String title;

    public JobTitle() {
    }
    
    public JobTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
