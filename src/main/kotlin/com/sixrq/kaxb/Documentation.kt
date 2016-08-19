package com.sixrq.kaxb

import org.w3c.dom.Node

class Documentation : Tag() {
    var value = ""

    override fun processText(item: Node) {
        value = item.nodeValue
    }

    override fun toString(): String{
        return "/**\n* ${value.replace("\n", "\n*")}\n*/"
    }
}