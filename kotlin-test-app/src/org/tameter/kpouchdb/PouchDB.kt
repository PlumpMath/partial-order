package org.tameter.kpouchdb

import org.tameter.kotlin.js.jsobject
import kotlin.js.Promise

/**
 * Copyright (c) 2016 Hugh Greene (githugh@tameter.org).
 */

@Suppress("unused")
external open class PouchDB(name: String, options: PouchDBOptions = definedExternally) {
    var name: String

    // Delete database
    fun destroy(/*options: JSMap<dynamic> = definedExternally*/): Promise<dynamic>

    // Create/update doc
    fun put(doc: PouchDoc): Promise<StoreResult>
    fun get(id: String): Promise<PouchDoc>

    // Batch create
    fun bulkDocs(docs: Array<out PouchDoc>/*, options: JSMap<dynamic> = definedExternally*/): Promise<Array<StoreResult>>

    // Batch fetch
    fun <T> allDocs(options: AllDocsOptions = definedExternally): Promise<BulkQueryResult<T>>

    // Database info
    fun info(): Promise<PouchDBInfo>
}

external interface PouchDBInfo

external interface PouchDBOptions
fun PouchDBOptions(): PouchDBOptions = jsobject()

external interface AllDocsOptions {
    var startkey : String
    var endkey: String
    var include_docs: Boolean
}
fun AllDocsOptions(): AllDocsOptions = jsobject()
