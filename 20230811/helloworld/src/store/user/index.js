const user = {
    state: {
        id: 1
    },
    getters: {
        getId(state) {
            return state.id
        }
    },
    mutations: {
        setId(state, id) {
            state.id = id
        }
    },
    actions: {}
}

export default user;