/*
 *    Copyright 2017 Simon Wiehe
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.sixrq.kaxb.parsers

import java.util.regex.Pattern

class Enumeration(xmlns: String) : Tag(xmlns) {
    override fun toString(): String{
        val enumeration = StringBuilder()
        enumeration.append("    @XmlEnumValue(\"${value}\")\n")
        enumeration.append("    ${value.split(Pattern.compile("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A=Z][a-z])")).joinToString("_").toUpperCase()}")
        if (value.isNotEmpty()) {
            enumeration.append("(\"$value\")")
        }
        enumeration.append(",")
        return enumeration.toString()
    }
}