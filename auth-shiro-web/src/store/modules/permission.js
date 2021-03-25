import { asyncRoutes, constantRoutes } from '@/router'

/**
 * Use meta.role to determine if the current user has permission
 * @param roles
 * @param route
 */
function hasPermission(menus, route) {
  return menus.some(menu => {
    console.log("menu"+menu)
    console.log("rout.path"+route.path)
   return  route.path.includes(menu.title)})
  // if (route.path && route.meta.title) {
  //
  // } else {
  //   return true
  // }
}

/**
 * Filter asynchronous routing tables by recursion
 * @param routes asyncRoutes
 * @param roles
 */
export function filterAsyncRoutes(routes, menus) {
  const res = []

  routes.forEach(route => {
    console.log(route)
    const tmp = { ...route }
    console.log(tmp)
    if (hasPermission(menus, tmp)) {
      console.log(111)
      if (tmp.children) {
        console.log(tmp)
        tmp.children = filterAsyncRoutes(tmp.children, menus)
      }
      res.push(tmp)
    }
  })

  return res
}

const state = {
  routes: [],
  addRoutes: []
}

const mutations = {
  SET_ROUTES: (state, routes) => {
    state.addRoutes = routes
    state.routes = constantRoutes.concat(routes)
  }
}

const actions = {
  generateRoutes({ commit }, menus) {
    return new Promise(resolve => {
      let accessedRoutes
      // if (menus.includes('admin')) {
      //   accessedRoutes = asyncRoutes || []
      // } else {
      //   accessedRoutes = filterAsyncRoutes(asyncRoutes, menus)
      // }
      accessedRoutes = filterAsyncRoutes(asyncRoutes, menus)
      // commit('SET_ROUTES', accessedRoutes)
      // resolve(accessedRoutes)
      commit('SET_ROUTES', asyncRoutes)
      resolve(asyncRoutes)
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
