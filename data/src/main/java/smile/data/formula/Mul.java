/*******************************************************************************
 * Copyright (c) 2010 Haifeng Li
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package smile.data.formula;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The term of a * b multiplication expression.
 * It is also referred as an interaction between factors
 * due to the influence of one factor on a response
 * depending on the level of another factor.
 *
 * @author Haifeng Li
 */
public class Mul<T> implements Factor<T, Double> {
    /** The first factor. */
    private Factor<T, Double> a;
    /** The second factor. */
    private Factor<T, Double> b;

    /**
     * Constructor.
     *
     * @param a the first factor.
     * @param b the second factor.
     */
    public Mul(Factor<T, Double> a, Factor<T, Double> b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return String.format("%s * %s", a, b);
    }

    @Override
    public List<Factor> factors() {
        return Collections.singletonList(this);
    }

    @Override
    public Set<String> variables() {
        Set<String> t = new HashSet<>(a.variables());
        t.addAll(b.variables());
        return t;
    }

    @Override
    public Double apply(T o) {
        return a.apply(o) * b.apply(o);
    }
}