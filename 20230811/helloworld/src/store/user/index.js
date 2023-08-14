const user = {
    state: {
        id: 1,
        username: ""
    },
    getters: {
        getId(state) {
            return state.id
        },
        getUsername(state) {
            return state.username
        }
    },
    mutations: {
        setId(state, id) {
            state.id = id
        },
        setUsername(state, username) {
            state.username = username
        },
        setUsernameAndId(state, user) {
            state.id = user.id;
            state.username = user.username;
        }
    },
    actions: {}
}

export default user;